package org.zaykin.teamwork.parser;

import org.zaykin.teamwork.exception.ParameterFormatException;

/**
 * Created by DHM on 6/4/2017.
 */
public class DataParser {

    public static String[] parseLine(String line, String delimiter, int lineNumber) throws ParameterFormatException{

        if (lineNumber < 1) {
            throw new ParameterFormatException(String.format("Line number cannot be less than 1; got: %d", lineNumber));
        }

        if (delimiter == null || delimiter.isEmpty()) {
            throw new ParameterFormatException(String.format("Line %d: delimiter is not set", lineNumber));
        }

        return line.split(delimiter);

    }

}
