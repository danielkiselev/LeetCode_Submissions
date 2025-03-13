/**
 * @return {Function}
 */
var createHelloWorld = function() {
    
    return function(...args) {
        const helloWorldString = "Hello World";
        return helloWorldString;
        
    }
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */