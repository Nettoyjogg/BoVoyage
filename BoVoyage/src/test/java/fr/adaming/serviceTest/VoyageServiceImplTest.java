package fr.adaming.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageDao;
import fr.adaming.model.Destination;
import fr.adaming.model.Voyage;
import fr.adaming.service.IVoyageService;

@RunWith(SpringJUnit4ClassRunner.class)//cette annotation sert � preciser que le lancement des tests 
//sera fait grace � la classe fourni par le module test de spring
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/application-context.xml"})
public class VoyageServiceImplTest {

	
	@Autowired
	private IVoyageService vService;
	
	
	
	//=====================Test Ajout Voyage
	//V�rifier que le voyage est bien ajout� � la liste des voyages
	@Test
	@Transactional
	@Rollback(true)//Des que le test est termin� la base de donn�e doit revenir � son �tat initial
	public void testAjouterVoyage(){
		Voyage vIn = new Voyage();
		
		
		//r�cup�erer la taille de la liste avant l'ajout
		int taillerelle=vService.afficherVoyages().size();
		
		vService.ajouterVoyage(vIn);
		
		assertEquals(taillerelle+1, vService.afficherVoyages().size());
	
	}
	
	
	//V�rifier que l'ajout ne d�nature pas le voyage
	@Test
	@Transactional
	@Rollback(true)//Des que le test est termin� la base de donn�e doit revenir � son �tat initial
	public void testAjouterVoyage1(){
		Destination dest = new Destination("Europe", "Maroc");
		Voyage vIn = new Voyage(10,null,null,300,true,dest,null,null);
		System.out.println(vIn);
		
		Voyage vOut=vService.ajouterVoyage(vIn);
		System.out.println(vOut);
		assertEquals(vIn, vOut);
	
	}
	
	//=====================Test Modifier Voyage
			//V�rifier que la modification s'effectue bien avec le bon nombre d'it�ration
		@Test
		@Transactional
		@Rollback(true)//Des que le test est termin� la base de donn�e doit revenir � son �tat initial
		public void testModifierVoyage(){
			Destination dest = new Destination("Europe", "Maroc");
			Voyage v1 = new Voyage(10,null,null,300,true,dest,null,null);
			System.out.println("-------------------------------------------------------------------------------------------------------------");
			System.out.println(v1);
			vService.ajouterVoyage(v1);
			v1.setPrix(400);
			int verif=vService.modifierVoyage(v1);
			System.out.println(v1);
			System.out.println("-------------------------------------------------------------------------------------------------------------");
			System.out.println(verif);
			assertEquals(verif, 1);
		
		}
		//=====================Test Rechercher Voyage
		//V�rifier que le voyage recherch� est le bon
		@Test
		@Transactional
		@Rollback(true)//Des que le test est termin� la base de donn�e doit revenir � son �tat initial
		public void testRechercherVoyage(){
			Destination dest = new Destination("Europe", "Maroc");
			Voyage v1 = new Voyage(1,10,null,null,300,true,dest,null,null);
			vService.ajouterVoyage(v1);
			Voyage v2 = vService.rechercherVoyage(v1);
			
			assertEquals(v1,v2);
		
		}
		
		
		//=====================Test Supprimer Voyage
		//V�rifier qu'un voyage est bien supprim� de la base de donn�e
		@Test
		@Transactional
		@Rollback(true)//Des que le test est termin� la base de donn�e doit revenir � son �tat initial
		public void testSupprimerVoyage(){
			Destination dest = new Destination("Europe", "Maroc");
			Voyage v1 = new Voyage(20,10,null,null,300,true,dest,null,null);
			vService.ajouterVoyage(v1);
			int tailleavant=vService.afficherVoyages().size();
			System.out.println("-------------------------------------------------------------------------");
			System.out.println(vService.afficherVoyages().size());
			vService.supprimerVoyage(v1);
			System.out.println(vService.afficherVoyages().size());
			System.out.println("--------------------------------------------------------------------------");
			int tailleapr�s=vService.afficherVoyages().size();
			assertEquals(tailleavant-1,tailleapr�s);
		
		}
	
	
	
}
