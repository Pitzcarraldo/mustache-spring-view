package org.springframework.web.servlet.view.mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheException;
import com.google.common.util.concurrent.UncheckedExecutionException;

/**
 * Mustache.java factory none using cache.
 * <p/>
 *
 * @author pitzcarraldo [http://pitzcarraldo.github.io/] <mrnoname@naver.com>
 */
public class NoneCacheMustacheFactory extends DefaultMustacheFactory {

    @Override
    public Mustache compile(String name) {
        try {
            Mustache mustache = mc.compile(name);
            mustache.init();
            return mustache;
        } catch (UncheckedExecutionException e) {
            throw handle(e);
        }
    }

    private MustacheException handle(Exception e) {
        Throwable cause = e.getCause();
        if (cause instanceof MustacheException) {
            return (MustacheException) cause;
        }
        return new MustacheException(cause);
    }
}
