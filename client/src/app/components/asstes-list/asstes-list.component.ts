import { Component, OnInit, HostBinding } from '@angular/core';

import { AsstesService } from '../../service/asstes.service'

@Component({
  selector: 'app-asstes-list',
  templateUrl: './asstes-list.component.html',
  styleUrls: ['./asstes-list.component.css']
})
export class AsstesListComponent implements OnInit {

  @HostBinding('class') classes = 'row';

  resDat: any = [];
  asstes: any = [];
  assestLoad: any = [];
  loadAss: any = [];
  typeAssig: any = [];
  area: any = [];
  person: any = [];
  status: any = [];

  constructor(private asstesService: AsstesService) { }

  ngOnInit() {
    this.asstesService.getAsstes().subscribe(
      res => {
        this.asstes = res;
      },
      err => {
        console.log(err);
      }
    );
  }

  load(id: string) {
    this.asstesService.getSearchAssets(id).subscribe(
      res => {
        this.resDat = res;
        if (this.resDat.status === 200) {
          this.loadAss = this.resDat.data;
        }
      },
      err => console.error(err)
    );
    this.asstesService.getTypeAssig().subscribe(
      res => {
        this.resDat = res;
        if (this.resDat.status === 200) {
          this.typeAssig = this.resDat.data;
        }
      },
      err => console.error(err)
    );
    this.asstesService.getArea().subscribe(
      res => {
        this.resDat = res;
        if (this.resDat.status === 200) {
          this.area = this.resDat.data;
        }
      },
      err => console.error(err)
    );
    this.asstesService.getPerson().subscribe(
      res => {
        this.resDat = res;
        if (this.resDat.status === 200) {
          this.person = this.resDat.data;
        }
      },
      err => console.error(err)
    );
    this.asstesService.getStatus().subscribe(
      res => {
        this.resDat = res;
        if (this.resDat.status === 200) {
          this.status = this.resDat.data;
        }
      },
      err => console.error(err)
    );
  }

  edit() {
    this.asstesService.editAssets(this.loadAss).subscribe(
      res => { 
        this.resDat = res;
        if (this.resDat.status === 200) {
          this.status = this.resDat.data;
        }
      },
      err => console.error(err)
    )
  }

  changeTypeAss(changeTypeAss, areaTmp, personTmp) {
    console.log(changeTypeAss);
    console.log(areaTmp.value);
    console.log(personTmp.value);
  }

}
