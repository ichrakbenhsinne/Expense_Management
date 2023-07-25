import { Component, OnInit } from '@angular/core';
import { Categorie } from 'src/app/Categorie';
import { Depence } from 'src/app/Depence';
import { UsersService } from 'src/app/users.service';

import { BsDatepickerConfig } from 'ngx-bootstrap/datepicker';
import * as bootstrap from 'bootstrap';



@Component({
  selector: 'app-depence',
  templateUrl: './depence.component.html',
  styleUrls: ['./depence.component.css']
})
export class DepenceComponent implements OnInit {
  depences: Depence[] = [];
  categories: Categorie[]= [];
  datePickerConfig: Partial<BsDatepickerConfig>;
  selectedDepartement: string | null = null;
  tableData: Depence[] = [];
  

  constructor(
    private userService: UsersService,
    
  ) {   this.datePickerConfig = {
    dateInputFormat: 'YYYY-MM-DD'
    
  };}


  showTypeDepenseModal(): void {
    const typeDepenseModal = document.getElementById('typeDepenseModal');
    if (typeDepenseModal) {
      const bsModal = new bootstrap.Modal(typeDepenseModal);
      bsModal.show();
    }
  }

  depenseType: string = ''; // Variable pour enregistrer la valeur choisie

  showForm: boolean = false; // Initialiser la variable showForm à false
  selectedDepenseType: string  | null = null; // Initialiser le type de dépense sélectionné à null

  saveDepenseType(): void {
    // Récupérer la valeur choisie
    this.selectedDepenseType = (<HTMLInputElement>document.querySelector('input[name="depenseType"]:checked'))?.value;
    console.log('Type de dépense sélectionné :', this.selectedDepenseType);
  
    // Vérifier si une valeur a été sélectionnée
    if (this.selectedDepenseType) {
      // Enregistrer la valeur choisie dans le service
      this.userService.setselectedtype(this.selectedDepenseType);
  
      // Afficher le formulaire associé au type de dépense
      this.showForm = true;
  
      // Ouvrir la fenêtre modale correspondant au type de dépense sélectionné
      switch (this.selectedDepenseType) {
        case 'Defaut':
          this.openDefaultDepenseModal();
          break;
        case 'Date':
          this.openDateDepenseModal();
          break;
        case 'multiples':
          this.openMultiplesDepenseModal();
          break;
        case 'Périodique':
          this.openPeriodiqueDepenseModal();
          break;
        case 'Hebdomadaire':
          this.openHebdomadaireDepenseModal();
          break;
        case 'Mensuel':
          this.openMensuelleDepenseModal();
          break;
        case 'Annuel':
          this.openAnnuelleDepenseModal();
          break;
        default:
          break;
      }
    }
  }
  
  
  
  
  /*
  saveDepenseType(): void {
    // Récupérer la valeur choisie
  //  const selectedDepenseType = (<HTMLInputElement>document.querySelector('input[name="depenseType"]:checked'))?.value;
  console.log(this.userService.selectedtype);
  
    // Vérifier si une valeur a été sélectionnée
    if (selectedDepenseType) {
      // Enregistrer la valeur choisie dans le service
      this.userService.setDepenseType(selectedDepenseType);
      switch (selectedDepenseType) {
        case 'Defaut':
          this.openDefaultDepenseModal();
          break;
        case 'Date':
          this.openDateDepenseModal();
          break;
        case 'multiples':
          this.openMultiplesDepenseModal();
          break;
        case 'Périodique':
          this.openPeriodiqueDepenseModal();
          break;
        case 'Hebdomadaire':
          this.openHebdomadaireDepenseModal();
          break;
        case 'Mensuel':
          this.openMensuelleDepenseModal();
          break;
        case 'Annuel':
          this.openAnnuelleDepenseModal();
          break;
        default:
          break;
      }

      console.log('Type de dépense sélectionné :', selectedDepenseType);
      }
      
  }
  */
  ngOnInit(): void {
    this.userService.selectedDepartement$.subscribe((selectedDepartement) => {
      if (selectedDepartement) {
        this.loadDepences(selectedDepartement);
        this.selectedDepartement = selectedDepartement; // Mettre à jour la propriété selectedDepartement
        for (const categorie of this.categories) {
          this.loadDepencesByCategorie(selectedDepartement, categorie.nomCategorie);
        }
      }
    });

    this.getCategories();
  
  }
  // Méthode pour ouvrir la fenêtre modale avec le formulaire "Par Defaut"
  openDefaultDepenseModal(): void {
    // Utiliser la méthode Bootstrap pour afficher la fenêtre modale
    const defaultModal = document.getElementById('defaultDepenseModal');
    if (defaultModal) {
      const bsModal = new bootstrap.Modal(defaultModal);
      bsModal.show();
    }
  }
  
  

  // Méthode pour ouvrir la fenêtre modale avec le formulaire "Par Date"
  openDateDepenseModal(): void {
    // Code pour ouvrir la fenêtre modale avec le formulaire "Par Date"
    const dateModal = document.getElementById('datetDepenseModal');
    if (dateModal) {
      const bsModal = new bootstrap.Modal(dateModal);
      bsModal.show();
    }
 
  }

  // Méthode pour ouvrir la fenêtre modale avec le formulaire "Dates multiples"
  openMultiplesDepenseModal(): void {
    // Code pour ouvrir la fenêtre modale avec le formulaire "Dates multiples"
  }

  // Méthode pour ouvrir la fenêtre modale avec le formulaire "Périodique"
  openPeriodiqueDepenseModal(): void {
    // Code pour ouvrir la fenêtre modale avec le formulaire "Périodique"
  }

  // Méthode pour ouvrir la fenêtre modale avec le formulaire "Dépense Hebdomadaire"
  openHebdomadaireDepenseModal(): void {
    // Code pour ouvrir la fenêtre modale avec le formulaire "Dépense Hebdomadaire"
  }

  // Méthode pour ouvrir la fenêtre modale avec le formulaire "Dépense Mensuelle"
  openMensuelleDepenseModal(): void {
    // Code pour ouvrir la fenêtre modale avec le formulaire "Dépense Mensuelle"
  }

  // Méthode pour ouvrir la fenêtre modale avec le formulaire "Dépense Annuelle"
  openAnnuelleDepenseModal(): void {
    // Code pour ouvrir la fenêtre modale avec le formulaire "Dépense Annuelle"
  }

  loadDepencesByCategorie(depname: string, catname: string): void {
    this.userService.getDepencesByDepBycategorie(depname, catname)
      .subscribe(depences => {
        this.depences = depences;
      });
  }
  
  
  loadDepences(departement: string): void {
    this.userService.getDepencesByDep(departement)
      .subscribe(depences => {
        this.depences = depences;
      });
  }

  
  
  

  getCategories(): void {
    this.userService.getCategories()
      .subscribe(categories => {
        this.categories = categories;
      });
  }

  controlerDepartement(): void {
    const selectedDepartement = this.userService.selectedDepartement;
    console.log('Département sélectionné:', selectedDepartement);
    // Autres opérations liées à la vérification du département sélectionné
  }

  

  
}
