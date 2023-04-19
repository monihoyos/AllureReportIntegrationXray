package com.example.test;

import com.example.test.utils.Listeners.TestListener;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

@Listeners({ TestListener.class })
@Epic("Allure TestNG Suite Tests")
@Feature("Allure TestNG Tests")
public class Launch extends BaseTest {

    public Properties fileprops = new Properties();

    public Properties getProperties() throws Exception {
        fileprops.load(new FileInputStream(new File("src/test/resources/test.properties").getAbsolutePath()));
        return fileprops;
    }

    @Test(priority=0, description="Realizar una búsqueda con resultados")
    @Severity(SeverityLevel.NORMAL)
    @Description("Realizar una búsqueda con resultados")
    @Story("Busqueda")
    @TmsLink("https://automationtestingfs.atlassian.net/browse/TNP-26")
    @Issue("TNP-123")
    public void test_busqueda_con_datos () throws Exception {
        buscadorPage.gotoBuscador(getProperties().getProperty("url"))
                    .searchText(getProperties().getProperty("textobusqueda1"))
                    .comprobarResultadoCorrecto();
    }

    @Test(priority=1, description="Realizar una búsqueda sin resultados")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Realizar una búsqueda sin resultados")
    @Story("Busqueda")
    @TmsLink("https://automationtestingfs.atlassian.net/browse/TNP-27")
    public void test_busqueda_sin_datos () throws Exception {
        buscadorPage.gotoBuscador(getProperties().getProperty("url"))
                     .searchText(getProperties().getProperty("textobusqueda2"))
                     .comprobarResultadoIncorrecto();
    }
}
