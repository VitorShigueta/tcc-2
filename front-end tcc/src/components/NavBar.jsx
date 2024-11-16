import { Routes, Route, Link } from "react-router-dom";

const NavBar = ({currentUser,logOut}) => {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container-fluid">
        <Link to={"/"} className="navbar-brand">
          DM
        </Link>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav  me-auto my-2 my-lg-0 navbar-nav-scroll">
            <li className="nav-item">
              <Link to={"/home"} className="nav-link">
                Home
              </Link>
              </li>
              {currentUser &&
              <li className="nav-item">
              <Link to={"/acao"} className="nav-link">
                Acao
              </Link>
            </li>}
              
          </ul>
          <form className="d-flex">
            {currentUser ? (
              <a href="/login" className="nav-link" onClick={logOut}>
                <button className="btn btn-outline-danger">Logout</button>
              </a>
        ) : (
          <>
              <Link to={"/login"} className="nav-link">
                <button className="btn btn-outline-success">Login</button>
              </Link>
              <Link to={"/register"} className="nav-link">
                <button className="btn btn-outline-success">Sign Up</button>
              </Link>
            </>
        )}
      
      </form>
        </div>
      </div>
    </nav>
  );
}

export default NavBar;