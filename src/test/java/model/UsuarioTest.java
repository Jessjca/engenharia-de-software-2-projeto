package model;

import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioTest {
    
    @Test
    public void testCriarUsuario() {
        Usuario usuario = new Usuario("Teste", "teste@email.com", "senha123");
        
        assertEquals("Teste", usuario.getNome());
        assertEquals("teste@email.com", usuario.getEmail());
        assertEquals("senha123", usuario.getSenha());
    }

    @Test
    public void testValidarEmail() {
        Usuario usuario = new Usuario("Teste", "teste@email.com", "senha123");
        assertTrue(usuario.validarEmail("teste@email.com"));
        assertFalse(usuario.validarEmail("email.invalido"));
    }

    @Test
    public void testValidarSenha() {
        Usuario usuario = new Usuario("Teste", "teste@email.com", "senha123");
        assertTrue(usuario.validarSenha("senha123"));
        assertFalse(usuario.validarSenha("senha.errada"));
    }

    @Test
    public void testSetId() {
        Usuario usuario = new Usuario("Teste", "teste@email.com", "senha123");
        usuario.setId(1);
        assertEquals(1, usuario.getId());
    }
} 