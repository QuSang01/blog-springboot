package top.yinzsw.blog.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import top.yinzsw.blog.enums.TokenTypeEnum;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * JWT claims数据模型
 *
 * @author yinzsW
 * @since 22/12/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ContextDTO {

    /**
     * 用户id
     */
    private Long uid;

    /**
     * token签名
     */
    private String sign;

    /**
     * 用户角色列表
     */
    private List<String> roles;

    /**
     * token类型
     */
    private TokenTypeEnum type;

    /**
     * 访问的资源id
     */
    @JsonIgnore
    private Long rid;

    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
    }
}
