/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Help;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class JTextFieldLimit extends DocumentFilter {

    private int limit;

    public JTextFieldLimit(int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit cann't be <= 0");
        }
        this.limit = limit;
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, 
            String text, AttributeSet attrs) throws BadLocationException {
        int currentLength = fb.getDocument().getLength();
        int overLimit = (currentLength + text.length()) - limit - length;
        if (overLimit > 0) {
            text = text.substring(0, text.length() - overLimit);
        }
        if (text.length() > 0) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
}
