package com.esprit.examen.services;

import com.esprit.examen.controllers.StockRestController;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.services.IStockService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StockRestControllerTest {

    @InjectMocks
    private StockRestController stockRestController;

    @Mock
    private IStockService stockService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetStocks() {
        List<Stock> stocks = new ArrayList<>();
        // Add some Stock objects to the list

        when(stockService.retrieveAllStocks()).thenReturn(stocks);

        List<Stock> result = stockRestController.getStocks();

        assertEquals(stocks, result);
    }

    @Test
    public void testRetrieveStock() {
        Long id = 1L; // Replace with the appropriate ID
        Stock stock = new Stock();
        // Initialize stock as needed

        when(stockService.retrieveStock(id)).thenReturn(stock);

        Stock result = stockRestController.retrieveStock(id);

        assertEquals(stock, result);
    }

    @Test
    public void testAddStock() {
        Stock stock = new Stock();
        // Initialize stock as needed

        when(stockService.addStock(any(Stock.class))).thenReturn(stock);

        Stock result = stockRestController.addStock(stock);

        assertEquals(stock, result);
    }

    @Test
    public void testRemoveStock() {
        Long id = 1L; // Replace with the appropriate ID
        doNothing().when(stockService).deleteStock(id);

        stockRestController.removeStock(id);

        verify(stockService, times(1)).deleteStock(id);
    }

    @Test
    public void testModifyStock() {
        Stock stock = new Stock();
        // Initialize stock as needed

        when(stockService.updateStock(any(Stock.class))).thenReturn(stock);

        Stock result = stockRestController.modifyStock(stock);

        assertEquals(stock, result);
    }

    // Uncomment the following test when the scheduled method is uncommented in the controller
    /*
    @Test
    public void testRetrieveStatusStock() {
        // Add test logic when needed
    }
    */
}
