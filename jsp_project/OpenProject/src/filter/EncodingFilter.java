package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	
	private String encoding;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// request 에 대한 필터 처리
		
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
		
		// response에 대한 처리

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		this.encoding = filterConfig.getInitParameter("encoding");
		
		if(encoding == null) {
			this.encoding = "utf-8";
		}

	}

}




