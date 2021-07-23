import * as app from "./app";
import * as math from "./math";
// Set all module functions to jest.fn
jest.mock("./math.js");
test("calls math.add", () => {
  app.doAdd(1, 2);
  expect(math.add).toHaveBeenCalledWith(1, 2);
});
test("calls math.subtract", () => {
  app.doSubtract(1, 2);
  expect(math.subtract).toHaveBeenCalledWith(1, 2);
});

test("calls math.multiply", () => {
  app.doMultiply(11, 23);
  expect(math.multiply).toHaveBeenCalledWith(11, 23);
});

test("calls math.divide", () => {
  app.doDivide(12, 3);
  expect(math.divide).toHaveBeenCalledWith(12, 3);
});