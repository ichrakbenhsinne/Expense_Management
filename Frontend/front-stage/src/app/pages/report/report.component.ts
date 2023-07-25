import { AfterViewInit, Component, OnInit } from '@angular/core';
import * as ApexCharts from 'apexcharts';


@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportsComponent implements OnInit, AfterViewInit {
  constructor() {}

  ngOnInit(): void {}
  ngAfterViewInit(): void {
    this.generateChart();
  }

  generateChart(): void {
    new ApexCharts(document.querySelector('#reportsChart'), {
      series: [
        { name: 'Sales', data: [31, 40, 28, 51, 42, 82, 56] },
        { name: 'Revenue', data: [11, 32, 45, 32, 34, 52, 41] },
        { name: 'Customers', data: [15, 11, 32, 18, 9, 24, 11] }
      ],
      chart: {
        height: 350,
        type: 'area',
        toolbar: { show: false }
      },
      markers: { size: 4 },
      colors: ['#4154f1', '#2eca6a', '#ff771d'],
      fill: {
        type: 'gradient',
        gradient: {
          shadeIntensity: 1,
          opacityFrom: 0.3,
          opacityTo: 0.4,
          stops: [0, 90, 100]
        }
      },
      dataLabels: { enabled: false },
      stroke: { curve: 'smooth', width: 2 },
      xaxis: {
        type: 'datetime',
        categories: [
          '2023-07-19T00:00:00.000Z',
          '2023-07-19T01:30:00.000Z',
          '2023-07-19T02:30:00.000Z',
          '2023-07-19T03:30:00.000Z',
          '2023-07-19T04:30:00.000Z',
          '2023-07-19T05:30:00.000Z',
          '2023-07-19T06:30:00.000Z'
        ]
      },
      tooltip: { x: { format: 'dd/MM/yy HH:mm' } }
    }).render();
  }
}