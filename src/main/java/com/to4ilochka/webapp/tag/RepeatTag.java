package com.to4ilochka.webapp.tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

import java.io.IOException;

public class RepeatTag extends SimpleTagSupport {
    private int times;

    public void setTimes(int times) {
        this.times = times;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        for (int i = 0; i < times; i++) {
            getJspBody().invoke(out);
        }
    }
}
