import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Departement } from 'src/app/Departement';
import { UsersService } from 'src/app/users.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {
  constructor(private service: UsersService, private router: Router) {}

  data: any;
  departements: Departement[] = []; // Tableau pour stocker les départements
  selectedDepartements: number[] = [];


  form = new FormGroup({
    name: new FormControl('', [Validators.required]),
    age: new FormControl('', [Validators.required]),
    identifiant: new FormControl('', [Validators.required]),
    id: new FormControl('', [Validators.required]),
    departements: new FormArray([], [Validators.required])
  });

  submit() {
    this.data = this.form.value;
    
    console.log(this.data);
  
    const selectedDepartements = this.form.value.departements?.map((checked, index) => checked ? this.departements[index].departementName : null)
  .filter(value => value !== null);

  
    this.data.depatements = selectedDepartements; // Mettre à jour la liste des départements sélectionnés
  
    this.service.adduser(this.data).subscribe(
      (data) => {
        console.log(data);
        this.form.reset();
        this.router.navigate(['/']);
      },
      (error) => {
        console.log(error);
      }
    );
  }
  
  
  getSelectedDepartements(): number[] {
    const selectedDepartements: number[] = [];
    const departementsFormArray = this.form.get('departements') as FormArray;
  
    departementsFormArray.controls.forEach((control, index) => {
      if (control.value) {
        selectedDepartements.push(index);
      }
    });
  
    return selectedDepartements;
  }
  
  ngOnInit(): void {
    // Appeler la méthode pour obtenir les départements
    this.service.getDepartements().subscribe(
      (departements) => {
        this.departements = departements;
        this.initializeDepartements();
      },
      (error) => {
        console.log(error);
      }
    );
  }

  initializeDepartements(): void {
    const departementsFormArray = this.form.get('departements') as FormArray;
    this.departements.forEach((departement) => {
      departementsFormArray.push(new FormControl(false));
    });
  }

  updateSelectedDepartements() {
    this.selectedDepartements = this.getSelectedDepartements();
  }
}
