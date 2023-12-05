const newman = require('newman');
const { exec } = require('child_process');

newman.run({
	collection: './AbstractaCollection.json',
	reporters: ['allure','cli']
},function (err){
	if(err){throw err;}
	console.log('pruebas terminadas exitosamente');
	exec('npx allure-commandline serve', (error, stdout, stderr) => {
        if (error) {
            console.error(`Error al ejecutar "allure serve": ${error.message}`);
            return;
        }
        if (stderr) {
            console.error(`allure serve stderr: ${stderr}`);
            return;
        }
        console.log(`Resultado de "allure serve": ${stdout}`);
    });
});
