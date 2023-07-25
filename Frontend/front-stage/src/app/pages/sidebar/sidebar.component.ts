import { Component, OnInit } from '@angular/core';
import { Departement } from 'src/app/Departement';
import { UsersService } from 'src/app/users.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  departements: Departement[] = [];

  constructor(public userService: UsersService) { }

  ngOnInit(): void {
    this.getDepartements();
    
  }

  getDepartements(): void {
    this.userService.getDepartements()
      .subscribe(departements => {
        this.departements = departements;
      });
  }

  selectDepartement(checked: boolean, departement: Departement): void {
    if (checked) {
      this.userService.setSelectedDepartement(departement.departementName);
    } else {
      // Traitez le cas où la case à cocher est décochée
    }
  }
  checkSelectedDepartement(): void {
    console.log(this.userService.selectedDepartement);
  }
  
  
  
}
