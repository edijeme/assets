import { Component, OnInit } from '@angular/core';

import { AsstesService } from '../../service/asstes.service'

@Component({
  selector: 'app-asstes-list',
  templateUrl: './asstes-list.component.html',
  styleUrls: ['./asstes-list.component.css']
})
export class AsstesListComponent implements OnInit {

  asstes: any = [];

  constructor(private asstesService: AsstesService) { }

  ngOnInit() {
    this.asstesService.getAsstes().subscribe(
      res => {
        this.asstes = res;
        console.log(this.asstes);
        console.log(Object.keys(this.asstes.data).length);
      },
      err => console.error(err)
    )
  }

}
