package com.example.menuManagement.jwt;

import com.google.common.base.Strings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtTokenVerifierFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if(Strings.isNullOrEmpty(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or missing JWT token");
//        }else{
            filterChain.doFilter(request, response);
            return;
        } //1 confirm the request header contains a token that begins with Bearer
        String token= authorizationHeader.replace("Bearer ", "");//2 removes the Bearer keyword from token
        String key = "securesecuresecuresecuresecuresecuresecuresecuresecuresecure";
        try {
            Jws<Claims> claimsJws = Jwts.parser() //3 extract/parse jws
                    .setSigningKey(Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8)))
                    .parseClaimsJws(token);
            Claims body = claimsJws.getBody();
            String username = body.getSubject();
            //check claim() in the SuccessfulAuthentication()
            var authorities = (List<Map<String,String>>) body.get("authorities");
            Set<SimpleGrantedAuthority> simpleGrantedAuthoritySet = authorities.stream()
                    .map((m)->new SimpleGrantedAuthority(m.get("authority")))
                    .collect(Collectors.toSet());//4. extract from jws the subject, the body and map authorities extracted from jws body into SimpleGrantedauthority object
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    simpleGrantedAuthoritySet
            ); //5. create an authentication token
            SecurityContextHolder.getContext().setAuthentication(authentication); //6. pass authentication object/token into SecurityContextHolder
        }catch (JwtException e){
            throw new IllegalStateException("Token cannot be trusted " + token);
        }
        //To pass request and response from a this filter to the next filter in the filterchain:
        filterChain.doFilter(request,response); //pass to the next filter

    }
}

