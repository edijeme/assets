import { Component, OnInit } from '@angular/core';

import { AsstesService } from '../../service/asstes.service'

@Component({
  selector: 'app-asstes-list',
  templateUrl: './asstes-list.component.html',
  styleUrls: ['./asstes-list.component.css']
})
export class AsstesListComponent implements OnInit {

  constructor(private asstesService: AsstesService) { }

  ngOnInit() {
    this.asstesService.getPerson().subscribe(
      res => console.log(res),
      res => console.error(res),

    )
  }

}
