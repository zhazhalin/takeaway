package com.qf.takeaway.config;

import io.jsonwebtoken.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * JWTToken 配置工具类
 */
@Component
@PropertySource(value = {"classpath:application.properties"})
public class JwtTokenConfig {

    //荷载中用户名的key
    private static final String CLAIM_KEY_USERNAME="sub";
    //创建时间
    private static final String CLAIM_KEY_CAEATE="exp";
    //秘钥
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    //失效时间
    private Long expiration;



    /**
     * 感觉用户信息生成token
     * @param userDetails springsecruity提供的
     * @return
     */
    public String generateToken(UserDetails userDetails){
        //创建荷载
        Map<String,Object> claims=new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CAEATE,new Date());
        System.out.println(userDetails.getUsername()+userDetails.getPassword());
        return generateToken(claims);
    }

    /**
     * 从token中获取登录用户名
     * @param token
     * @return
     */
    public String getUserNameFromToken(String token){
        String username;

        try {
            Claims claims=getClaimsFromToken(token);

            username =claims.getSubject();
        } catch (Exception e) {
            return null;
        }
        return username;
    }


    /**
     * 判断token是否有效
     * @param token
     * @param userDetails
     * @return
     */
    public boolean validateToken(String token, UserDetails userDetails){
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername())&& !isTokenExpired(token);

    }

    /**
     * 判断token是否可以刷新
     * @param token
     */
    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token){
        Claims claims=getClaimsFromToken(token);
        //只需要修改过期时间即可
        claims.put(CLAIM_KEY_CAEATE,new Date());
        return generateToken(claims);
    }

    /**
     * 判断token是否失效
     * @param token
     * @return
     */
    private boolean isTokenExpired(String token) {
        Date date=getExpiredDateFromToken(token);

        //如果在当前时间前面 就失效
        return date.before(new Date());
    }

    /**
     * 从token中获取失效时间
     * @param token
     * @return
     */
    private Date getExpiredDateFromToken(String token) {
        Claims claims=getClaimsFromToken(token);
        return claims.getExpiration();

    }

    /**
     * 从token中获取荷载
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims=null;

        try {
            claims=Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }


    /**
     * 私有方法：根据荷载生成 JWT token
     * @return
     */
    private String generateToken(Map<String,Object> claims){
        return  Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

    }

    /**
     * 生成token失效时间
     * @return
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis()+expiration*1000);
    }
}
