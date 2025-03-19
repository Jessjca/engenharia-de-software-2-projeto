import javax.swing.*;
import java.awt.*;

public class TextShadowLabel extends JLabel {
    private Color shadowColor;
    private int shadowOffset;

    public TextShadowLabel(String text) {
        super(text);
        this.shadowColor = new Color(0, 0, 0, 100);
        this.shadowOffset = 2;
    }

    public TextShadowLabel(String text, Color shadowColor, int shadowOffset) {
        super(text);
        this.shadowColor = shadowColor;
        this.shadowOffset = shadowOffset;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        
        // Desenha a sombra
        g2d.setColor(shadowColor);
        g2d.drawString(getText(), shadowOffset, shadowOffset + g2d.getFontMetrics().getAscent());
        
        // Desenha o texto principal
        g2d.setColor(getForeground());
        g2d.drawString(getText(), 0, g2d.getFontMetrics().getAscent());
    }
} 