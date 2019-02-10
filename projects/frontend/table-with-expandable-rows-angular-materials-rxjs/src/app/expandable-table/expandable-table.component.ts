import {Component, OnInit} from '@angular/core';
import {animate, state, style, transition, trigger} from '@angular/animations';

@Component({
  selector: 'app-expandable-table',
  templateUrl: './expandable-table.component.html',
  styleUrls: ['./expandable-table.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0', display: 'none'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class ExpandableTableComponent implements OnInit {
  dataSource = [
    {
      position: 0,
      name: 'Hydrogen',
      description: `Hydrogen is a chemical element with symbol H and atomic number 1. With a standard
        atomic weight of 1.008, hydrogen is the lightest element on the periodic table.`
    },
    {
      position: 1,
      name: 'Whatever',
      description: `WhateverWhateverWhateverWhateverWhatever WhateverWhateverWhateverWhatever
      WhateverWhateverWhateverWhateverWhateverWhatever`
    }

    ];
  columnsToDisplay = ['name', 'weight', 'symbol', 'position'];
  expandedElement: PeriodicElement | null;

  constructor() { }

  ngOnInit() {
  }

}

export interface PeriodicElement {
  name: string;
  position: number;
  description: string;
}
