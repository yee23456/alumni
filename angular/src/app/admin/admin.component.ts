import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
})
export class AdminComponent implements OnInit {
  data: any[] = [];
  client: any[] = [];
  months: string[] = [];
  newItemyesno: boolean[] = [];
  selectedMonth: string = new Date().toLocaleString('default', {
    month: 'long',
  });
  item: any; // 定義 item 屬性
  newItem: any; // 定義 newItem 屬性
  constructor(private http: HttpClient) {
    this.generateMonths();
    this.item = {}; // 初始化 item 屬性
  }
  ngOnInit(): void {
    this.onGetClientData();
  }

  onGetClientData() {
    this.http
      .get<any[]>('http://localhost:8080/robot/all')
      .subscribe((client) => {
        console.log(client);
        this.client = client;
      });
  }
  generateMonths() {
    const currentMonth = new Date().getMonth();
    for (let i = currentMonth; i >= 0; i--) {
      this.months.push(
        new Date(0, i).toLocaleString('default', { month: 'long' })
      );
    }
  }
  onModifyData(id: string, item: any) {
    console.log('id:', id);
    console.log('item.yesNo:', item.yesNo);
    if (item.yesNo) {
      item.yesNo = true;
    } else {
      item.yesNo = false;
    }
    this.http
      .post('http://localhost:8080/robot/requstyesno/' + `${id}`, item.yesNo)
      .subscribe((data) => {
        console.log('result', item.yesNo);
      });
  }
  onDeleteData(id: string) {
    this.http.delete(`http://localhost:8080/robot/${id}`).subscribe((_) => {
      console.log('成功刪除id :', id);
    });
    setTimeout(() => {
      this.onGetClientData();
    }, 500);
  }
}
