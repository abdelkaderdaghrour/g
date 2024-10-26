package com.esprit.examen.services;

import com.esprit.examen.controllers.SecteurActiviteController;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.services.ISecteurActiviteService;
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
public class SecteurActiviteControllerTest {

    @InjectMocks
    private SecteurActiviteController secteurActiviteController;

    @Mock
    private ISecteurActiviteService secteurActiviteService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetSecteurActivite() {
        List<SecteurActivite> secteurActivites = new ArrayList<>();
        // Add some SecteurActivite objects to the list

        when(secteurActiviteService.retrieveAllSecteurActivite()).thenReturn(secteurActivites);

        List<SecteurActivite> result = secteurActiviteController.getSecteurActivite();

        assertEquals(secteurActivites, result);
    }

    @Test
    public void testRetrieveSecteurActivite() {
        Long id = 1L; // Replace with the appropriate ID
        SecteurActivite secteurActivite = new SecteurActivite();
        // Initialize secteurActivite as needed

        when(secteurActiviteService.retrieveSecteurActivite(id)).thenReturn(secteurActivite);

        SecteurActivite result = secteurActiviteController.retrieveSecteurActivite(id);

        assertEquals(secteurActivite, result);
    }

    @Test
    public void testAddSecteurActivite() {
        SecteurActivite secteurActivite = new SecteurActivite();
        // Initialize secteurActivite as needed

        when(secteurActiviteService.addSecteurActivite(any(SecteurActivite.class))).thenReturn(secteurActivite);

        SecteurActivite result = secteurActiviteController.addSecteurActivite(secteurActivite);

        assertEquals(secteurActivite, result);
    }

    @Test
    public void testRemoveSecteurActivite() {
        Long id = 1L; // Replace with the appropriate ID
        doNothing().when(secteurActiviteService).deleteSecteurActivite(id);

        secteurActiviteController.removeSecteurActivite(id);

        verify(secteurActiviteService, times(1)).deleteSecteurActivite(id);
    }

    @Test
    public void testModifySecteurActivite() {
        SecteurActivite secteurActivite = new SecteurActivite();
        // Initialize secteurActivite as needed

        when(secteurActiviteService.updateSecteurActivite(any(SecteurActivite.class))).thenReturn(secteurActivite);

        SecteurActivite result = secteurActiviteController.modifySecteurActivite(secteurActivite);

        assertEquals(secteurActivite, result);
    }
}
