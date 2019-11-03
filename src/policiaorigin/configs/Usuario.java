/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package policiaorigin.configs;

import java.util.prefs.Preferences;

/**
 *
 * @author John
 */
// não está funcionando
public class Usuario {
    private static final String nome = "Desconhecido";
    Preferences prefs = Preferences.userNodeForPackage(Example.class);

    public void setNome(String Nome) {
        prefs.put(nome, Nome);
    }

    public String getNome() {
        return prefs.get(nome, "default");
    }
}
