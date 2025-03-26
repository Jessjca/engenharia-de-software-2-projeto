package view;

import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.JFrame;

public class MainViewTest {
    
    @Test
    public void testInicializacao() {
        MainView view = new MainView();
        assertNotNull(view);
        assertTrue(view instanceof JFrame);
        assertEquals("Sistema de Agenda", view.getTitle());
    }

    @Test
    public void testVisibilidade() {
        MainView view = new MainView();
        assertFalse(view.isVisible());
        view.setVisible(true);
        assertTrue(view.isVisible());
    }

    @Test
    public void testTamanho() {
        MainView view = new MainView();
        assertEquals(400, view.getWidth());
        assertEquals(300, view.getHeight());
    }

    @Test
    public void testOperacaoFechamento() {
        MainView view = new MainView();
        assertEquals(JFrame.EXIT_ON_CLOSE, view.getDefaultCloseOperation());
    }
} 