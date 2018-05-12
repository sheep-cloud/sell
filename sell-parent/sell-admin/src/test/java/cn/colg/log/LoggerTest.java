package cn.colg.log;

import org.junit.Test;

import cn.colg.BaseTest;
import lombok.extern.slf4j.Slf4j;

/**
 * 日志测试
 *
 * @author colg
 */
@Slf4j
public class LoggerTest extends BaseTest {

    @Test
    public void testLog() throws Exception {
        log.debug("LoggerTest.testLog() >> debug : {}", "DEBUG 级别");
        log.info("LoggerTest.testLog() >> info : {}", "DEBUG 级别");
        log.warn("LoggerTest.testLog() >> warn : {}", "WARN 级别");
        log.error("LoggerTest.testLog() >> error : {}", "ERROR 级别");
    }
}
