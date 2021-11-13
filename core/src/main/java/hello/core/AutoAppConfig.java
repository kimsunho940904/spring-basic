package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    /**
     * 1. 컴포넌트 스캔을 사용하려면 먼저 @ComponentScan을 설정 정보에 붙여주어야 한다.
     * 2. 기존의 AppConfig와는 다르게 @Bean으로 등록한 클래스가 하나도 없다.
     */



}
