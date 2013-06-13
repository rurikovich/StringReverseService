package org.stringReverse;

import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Rurik
 * Date: 11.06.13
 * Time: 22:34
 * To change this template use File | Settings | File Templates.
 */
@Service
public class StringReverseServiceImpl implements StringReverseService {

    public String getOutput(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
