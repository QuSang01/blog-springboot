package top.yinzsw.blog.handler;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import top.yinzsw.blog.util.PageUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * 分页拦截器
 *
 * @author yinzsW
 * @since 2022/12/15
 **/
@Component
@AllArgsConstructor
public class PageableHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             @NotNull HttpServletResponse response,
                             @NotNull Object handler) {
        String currentPage = request.getParameter(PageUtils.PARAMS_PAGE);
        if (StringUtils.hasText(currentPage)) {
            String pageSize = Optional.ofNullable(request.getParameter(PageUtils.PARAMS_SIZE)).orElse(PageUtils.DEFAULT_SIZE);
            PageUtils.setCurrentPage(new Page<>(Long.parseLong(currentPage), Long.parseLong(pageSize)));
        }
        return true;
    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest request,
                                @NotNull HttpServletResponse response,
                                @NotNull Object handler,
                                Exception ex) {
        PageUtils.remove();
    }
}