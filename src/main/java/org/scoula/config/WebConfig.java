package org.scoula.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 파일 업로드 설정 상수 (private static final로 선언)
    private static final String LOCATION = "c:/upload";
    private static final long MAX_FILE_SIZE = 1024 * 1024 * 10L;       // 10MB
    private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 20L;    // 20MB
    private static final int FILE_SIZE_THRESHOLD = 1024 * 1024 * 5;    // 5MB

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { ServletConfig.class };
    }

    // DispatcherServlet이 매핑될 URL 패턴 설정
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    // UTF-8 문자 인코딩 필터 등록
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] { characterEncodingFilter };
    }

    // DispatcherServlet 등록 시 추가 설정 (파일 업로드 및 예외처리)
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");

        MultipartConfigElement multipartConfig = new MultipartConfigElement(
                LOCATION,        // 업로드 처리 디렉토리 경로
                MAX_FILE_SIZE,   // 업로드 가능한 파일 하나의 최대 크기
                MAX_REQUEST_SIZE,// 업로드 가능한 전체 최대 크기(여러 파일 업로드 시)
                FILE_SIZE_THRESHOLD // 메모리에서 작업할 최대 파일 크기
        );
        registration.setMultipartConfig(multipartConfig);
    }
}
