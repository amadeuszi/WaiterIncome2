import { Component, OnInit } from '@angular/core';
import {TipServiceService} from '../tip-service.service';
import {AllTips} from '../allTips';
import {Tip} from '../tip';

@Component({
  selector: 'app-tips',
  templateUrl: './tips.component.html',
  styleUrls: ['./tips.component.css']
})
export class TipsComponent implements OnInit {

  constructor(private tipService: TipServiceService) {
  }

  config = {
    allTips: [],
    sum: 0
  };

  newTip = {
    id: null,
    amount: null,
    description: null,
    creationDate: null
  };

  ngOnInit() {
    this.emptyNewTip();
    this.refreshConfig()
  }

  refreshConfig() {
    this.tipService.getAllTips()
      .subscribe((allTips: AllTips) => this.config = {
        sum: allTips.sumOfTips,
        allTips:  allTips.allTips
      });
  }

  emptyNewTip() {
    this.newTip = {
      id: null,
      amount: null,
      description: null,
      creationDate: null
    };
  }

  addNewTip() {
    this.tipService.addNewTip(this.newTip)
      .subscribe((tip: Tip) => {
        this.config.allTips.push(tip);
        this.emptyNewTip();
        this.config.sum += tip.amount;
      });
  }
}
