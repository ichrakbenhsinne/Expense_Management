import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Utilisateur } from 'Utilisateur';
import { Departement } from './Departement';
import { BehaviorSubject, Observable } from 'rxjs';
import { Depence } from './Depence';
import { EventEmitter } from '@angular/core';
import { Categorie } from './Categorie';


@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private url = "http://localhost:8063/user/";
  private url2 ="http://localhost:8050/depences/"


  selectedDepartement: string | null = null;
  selectedDepartementChanged: EventEmitter<string> = new EventEmitter<string>();
  private selectedDepartementSubject: BehaviorSubject<string | null> = new BehaviorSubject<string | null>(null);
  public selectedDepartement$: Observable<string | null> = this.selectedDepartementSubject.asObservable();
  depenseType: string = '';
  //selectedDepartementChanged: EventEmitter<string> = new EventEmitter<string>();


  selectedtype: string | null = null;
  selectedtypeChanged: EventEmitter<string> = new EventEmitter<string>();
  private selectedtypeSubject: BehaviorSubject<string | null> = new BehaviorSubject<string | null>(null);
  public selectedtype$: Observable<string | null> = this.selectedtypeSubject.asObservable();                                                        
  

  constructor(private http: HttpClient) { }

  // Add User -create
  adduser(utilisateur: Utilisateur) {
    return this.http.post<Utilisateur>(`${this.url}add`, utilisateur);
  }

  // get all departements
  getDepartements(): Observable<Departement[]> {
    return this.http.get<Departement[]>(`${this.url}all`);
  }

  // Add dep to user 
  AdddepToUser(depname: string, user: Utilisateur): Observable<any> {
    const params = new HttpParams().set('user', JSON.stringify(user));
    return this.http.get<any>(`${this.url}addDepartement/${depname}`, { params });
  }

  // get all depences
  getDepencesByDep(depname: string): Observable<Depence[]> {
    const params = new HttpParams().set('depname', depname);
    return this.http.get<Depence[]>(`${this.url}getdepences/${depname}`);
  }

  setSelectedDepartement(departementName: string): void {
    this.selectedDepartementSubject.next(departementName);

    // Autres opérations liées au département sélectionné
  }

  setselectedtype(value: string): void {
    this.selectedtype = value;
    this.selectedtypeSubject.next(value); // Émettre la nouvelle valeur aux abonnés
  }

// add depense par date
addDepensedate(depence: Depence) {
  return this.http.post<Depence>(`${this.url}adddatedepence`, depence);
}

// add depense par date multiple
addDepensemultip(depence: Depence) {
  return this.http.post<Depence>(`${this.url}AddDepMultDate`, depence);
}

// add depense periodique
addDepenseperiodique(depence: Depence) {
  return this.http.post<Depence>(`${this.url}AddPeriodDepence`, depence);
}
// add depense personnalise
addDepensepersonnelle(depence: Depence) {
  return this.http.post<Depence>(`${this.url}addpersDep`, depence);
}

// add depense par defaut
addDefaultDepense(depence: Depence) {
  return this.http.post<Depence>(`${this.url}addDef`, depence);
}

// get all categories

getCategories(): Observable<Categorie[]> {
  return this.http.get<Categorie[]>(`${this.url2}allcategories`);
}

// get depenses by date d'un departement
getDepencesByDepByDate(depname: string, date: Date): Observable<Depence[]> {
  const params = new HttpParams()
    .set('departName', depname)
    .set('date', date.toISOString()); // Convertir la date en format ISO string

  return this.http.get<Depence[]>(`${this.url}getdepensesDepartDate`, { params });
}

//get depances by categorie d'un departement
getDepencesByDepBycategorie(depname: string, catname: string): Observable<Depence[]> {
  const params = new HttpParams()
    .set('departName', depname)
    .set('catname', catname);

  return this.http.get<Depence[]>(`${this.url}getdepensesDepartCategorie`, { params });
}



}


