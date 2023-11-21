import React from "react";
import CrudCliente from "./src/Components/CrudCliente";
import ReactDOM from 'react-dom';


function App() {

return (
 <div >
    <CrudCliente />
  </div>
);


ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

}

export default App;