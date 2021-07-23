import * as app from "./app";
import * as math from "./math";
test("calls math.add", () => {
  // store the original implementation
  const originalAdd = math.add;
  // mock add with the original implementation
  math.add = jest.fn(originalAdd);
  // spy the calls to add
  expect(app.doAdd(1, 2)).toEqual(3);
  expect(math.add).toHaveBeenCalledWith(1, 2);
  // override the implementation
  math.add.mockImplementation(() => "mock");
  expect(app.doAdd(1, 2)).toEqual("mock");
  expect(math.add).toHaveBeenCalledWith(1, 2);
  // restore the original implementation
  math.add = originalAdd;
  expect(app.doAdd(1, 2)).toEqual(3);
});

/*Descripción de funcionamiento: 
Desde la línea de código 3 hasta la 7, se reasigna una función 
(en este caso la función math.add) a la función del mock, con el 
objetivo de que se logre llamar al mock en lugar de la función original 
en cualquier lugar del código en donde se vaya a usar; 
luego en las líneas de código 9 y 10 se “espía” el llamado de la función, 
dejando la implementación original sin afectar 
(se observa que no se reemplaza con un mock ). 
En las líneas de código 12 a la 17, se realiza la simulación de la función para mockear
su funcionamiento (sobrescribiendo), 
luego se podrá restaurar la implementación original*/ 
