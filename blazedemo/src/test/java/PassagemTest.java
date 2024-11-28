// 1 - bibliotecas / imports
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; // biclioteca principal do Selenium
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// 2 - Classe
public class PassagemTest {
    // 2.1 - Atributos
    private WebDriver driver; // objeto do Selenium

    // 2.2 - Funçoes e Meétodos

    // Antes do Teste
    @BeforeEach
    public void iniciar() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximiza janela do browser

    }

    // Depois do Teste
    public void finalizar () {
        driver.quit();
    }

    // Teste
    @Test
    public void comprarPassagem (){
        driver.get("https://www.blazedemo.com"); // abre o site
        // seleciona origem, destino e apertar o botão "Find Flights"
        
        //combo Origem
        driver.findElement(By.name("fromPort")).click(); // clica no combo
        {
            WebElement dropdowWebElement = driver.findElement(By.name("fromPort"));
            dropdowWebElement.findElement(By.xpath("//option[.='São Paolo']")).click();
        }
        
        // combo Destino
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.click();
            dropdown.findElement(By.xpath("//option[.='Cairo']")).click();
        }

        //clicar no botão
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        //transiçãoDePagina

        // VerificaSeFoiRealizadoOLoginEAPesquisaDosVoos
        assertEquals("Flights from São Paolo to Cairo:", 
        driver.findElement(By.cssSelector("h3")).getText());  

        //clicarNoVooDesejado
        driver.findElement(By.cssSelector("tr:nth-child(1) .btn")).click();
        assertEquals("Your flight from TLV to SFO has been reserved.",
        driver.findElement(By.cssSelector("h2")).getText());
    } // finalDoComparPassagem

} //finalClassePassagemTest