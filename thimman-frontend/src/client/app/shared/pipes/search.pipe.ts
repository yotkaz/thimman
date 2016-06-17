import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
    name: 'SearchPipe'
})
export class SearchPipe implements PipeTransform {

    transform(value: any[], searchText: any, field: any) {
        if (!searchText) {
            return value;
        }
        return value.filter((item) => {
            if (field) {
                return item[field].toLowerCase().includes(searchText.toLowerCase());
            }
            return true;
        })
    }

}