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
public class Config {
    public int build = 20191109;
    public String versao = "0.02 [Alpha]";
    Preferences prefs = Preferences.userNodeForPackage(Example.class);
    
    private static final String buildB = "20191109";
    private static final String versaoB = "0.02 [Alpha]";
    private static final String needB = "0";
    private static final String link = "";
    private static final String mensagem = "";
    
    public void setBuild(String Valor) {
        prefs.put(buildB, Valor);
    }
    public String getBuild() {
        return prefs.get(buildB, "default");
    }
    
    public void setVersao(String Valor) {
        prefs.put(versaoB, Valor);
    }
    public String getVersao() {
        return prefs.get(versaoB, "default");
    }
    
    public void setNeed(String Valor) {
        prefs.put(needB, Valor);
    }
    public boolean getNeed() {
        int nidi = Integer.parseInt(prefs.get(needB, "default"));
        return nidi >= 1;
    }
    
    public void setLink(String Valor) {
        prefs.put(link, Valor);
    }
    public String getLink() {
        return prefs.get(link, "default");
    }
    
    public void setMensagem(String Valor) {
        prefs.put(mensagem, Valor);
    }
    public String getMensagem() {
        return prefs.get(mensagem, "default");
    }
    
    public boolean VerificarAtt(){
        int AttBuild1 = build;
        int AttBuild2 = Integer.parseInt(prefs.get(buildB, "default"));
        return AttBuild1 < AttBuild2;
    }
}
