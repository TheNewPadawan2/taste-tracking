import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pairSequenceMatch',
  pure: true
})
export class PairSequenceMatchPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): boolean {
    let array0: any[] = [];
    let array1: any[] = [];
    array0.push(value);
    if (args !== undefined) {
      for (let i = 0; i < args.length; i++) {
        if (i % 2 == 0) array1.push(args[i]);
        else array0.push(args[i]);
      }
    }
    for (let i = 0; i < array1.length; i++) {
      if (typeof array0[i] === 'string' && typeof array1[i] === 'string') {
        if ((array0[i] as string).toLowerCase().trim() !== (array1[i] as string).toLowerCase().trim()) return false;
      } else if (array0[i] !== array1[i]) return false;
    }
    return true;
  }

}
