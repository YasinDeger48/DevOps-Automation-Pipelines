import logo1 from './logo1.svg';
import logo2 from './logo2.svg';

import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
      <p>         <img src={logo1} className="App-logo" alt="logo1" />
                  <img src={logo2} className="App-logo" alt="logo2" /></p>


        <p>
          Dev Ops RoadMap - 2024
        </p>
               <a
                          className="App-link"
                          href="https://www.docker.com/"
                          target="_blank"
                          rel="noopener noreferrer"
                        >
                          Welcome to Docker
                        </a>
        <a
          className="App-link"
          href="https://kubernetes.io/"
          target="_blank"
          rel="noopener noreferrer"
        >
          Welcome to K8s
        </a>

      </header>
    </div>
  );
}

export default App;
