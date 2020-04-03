package com.shiyifan.MybatisPlusConfig;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByIdWithFill;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@Configuration
@EnableTransactionManagement//自动管理事务
//扫描mapper文件夹
@MapperScan("com.shiyifan.mapper")
public class MybatisPlusConfig {
    //注册乐观锁插件
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }
    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        //PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        //paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return new PaginationInterceptor();
    }
    //逻辑删除插件
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector(){
            //让逻辑删除中能够更新修改时间
            @Override
            public List<AbstractMethod> getMethodList() {
                List<AbstractMethod> methodList = super.getMethodList();
                methodList.add(new LogicDeleteByIdWithFill());
                return methodList;
            }
        };
    }
    //性能分析插件
    @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(1000);//设置sql执行的最大时间，超过则不执行，单位ms
        performanceInterceptor.setFormat(true);//设置sql格式化
        return performanceInterceptor;
    }
}
