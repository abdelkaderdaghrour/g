package com.esprit.examen.services;

import com.esprit.examen.controllers.FournisseurRestController;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.services.IFournisseurService;
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
public class FournisseurRestControllerTest {

    @InjectMocks
    private FournisseurRestController fournisseurRestController;

    @Mock
    private IFournisseurService fournisseurService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFournisseurs() {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        // Add some Fournisseur objects to the list

        when(fournisseurService.retrieveAllFournisseurs()).thenReturn(fournisseurs);

        List<Fournisseur> result = fournisseurRestController.getFournisseurs();

        assertEquals(fournisseurs, result);
    }

    @Test
    public void testRetrieveFournisseur() {
        Long id = 1L; // Replace with the appropriate ID
        Fournisseur fournisseur = new Fournisseur();
        // Initialize fournisseur as needed

        when(fournisseurService.retrieveFournisseur(id)).thenReturn(fournisseur);

        Fournisseur result = fournisseurRestController.retrieveFournisseur(id);

        assertEquals(fournisseur, result);
    }

    @Test
    public void testAddFournisseur() {
        Fournisseur fournisseur = new Fournisseur();
        // Initialize fournisseur as needed

        when(fournisseurService.addFournisseur(any(Fournisseur.class))).thenReturn(fournisseur);

        Fournisseur result = fournisseurRestController.addFournisseur(fournisseur);

        assertEquals(fournisseur, result);
    }

    @Test
    public void testRemoveFournisseur() {
        Long id = 1L; // Replace with the appropriate ID
        doNothing().when(fournisseurService).deleteFournisseur(id);

        fournisseurRestController.removeFournisseur(id);

        verify(fournisseurService, times(1)).deleteFournisseur(id);
    }

    @Test
    public void testModifyFournisseur() {
        Fournisseur fournisseur = new Fournisseur();
        // Initialize fournisseur as needed

        when(fournisseurService.updateFournisseur(any(Fournisseur.class))).thenReturn(fournisseur);

        Fournisseur result = fournisseurRestController.modifyFournisseur(fournisseur);

        assertEquals(fournisseur, result);
    }

    @Test
    public void testAssignSecteurActiviteToFournisseur() {
        Long idSecteurActivite = 1L; // Replace with the appropriate ID
        Long idFournisseur = 1L; // Replace with the appropriate ID
        doNothing().when(fournisseurService).assignSecteurActiviteToFournisseur(idSecteurActivite, idFournisseur);

        fournisseurRestController.assignProduitToStock(idSecteurActivite, idFournisseur);

        verify(fournisseurService, times(1)).assignSecteurActiviteToFournisseur(idSecteurActivite, idFournisseur);
    }
}
