import { Component, OnInit } from '@angular/core';
import { OpenehrSdkService } from '../openehr-sdk.service';

@Component({
  selector: 'app-ehr',
  templateUrl: './ehr.component.html',
  styleUrls: ['./ehr.component.scss']
})
export class EhrComponent implements OnInit {

  ehrId: string;

  constructor(private ehrService: OpenehrSdkService) { }

  ngOnInit(): void {

  this.ehrService.currentEhrId.subscribe(
    ehrId => this.ehrId = ehrId )
  }

  createEhr() {
    this.ehrService.createEhr().subscribe(
      response => {
        this.ehrService.changeEhrId(response.ehr_id);
      }
    )
  }

}
