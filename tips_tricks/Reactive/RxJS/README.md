Redukcja strumienia do jednego objektu docelowego.

Scan podczas redukcji emituje wartości pośrednie

```javascript
import { of } from 'rxjs';
import { scan, reduce } from 'rxjs/operators';
 
const source = of(1, 2, 3, 4);
const startValue = 10; // wartość startowa
 
const reduceSource = source.pipe(reduce((acctual, val) => acctual + val, startValue));
const reduceSubscribe = reduceSource.subscribe(r => console.log('Reduce Sum:', r));
// Reduce Sum: 20
 
const scanSource = source.pipe(scan((acctual, val) => acctual + val));
const scanSubscribe = scanSource.subscribe(s => console.log('Scan Sum:', s));
// Scan Sum: 1
// Scan Sum: 3
// Scan Sum: 6
// Scan Sum: 10
```
