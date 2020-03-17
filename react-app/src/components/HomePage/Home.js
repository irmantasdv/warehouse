import React, { Component } from 'react';
import { Link } from "react-router-dom";

class Home extends Component {


    render() {
        return (
            <div className="container text-center">
                <div className="row">
  
                    <div className="card text-white bg-secondary col m-3" >
                        <Link className="text-white text-decoration-none" to="/products">
                        <div className="card-header"><h3>Products</h3></div>
                        <div className="card-body">
                            <h5 className="card-title">All Warehouse Products</h5>
                            <p className="card-text">Create, update, delete products</p>
                        </div>
                        </Link>
                    </div>
                    <div className="card text-white bg-success col m-3" >
                    <Link className="text-white text-decoration-none" to="/products">
                        <div className="card-header"><h3>Clients</h3></div>
                        <div className="card-body">
                            <h5 className="card-title">List Of Clients</h5>
                            <p className="card-text">Create, Update, Delete Orders and Clients</p>
                        </div>
                        </Link>
                    </div>
                    </div>
                    <div className="row">
                    <div className="card text-white bg-success col m-3" >
                    <Link className="text-white text-decoration-none" to="/products">
                        <div className="card-header"><h3>Manufacturers & Suppliers</h3></div>
                        <div className="card-body">
                            <h5 className="card-title">Products Suppliers</h5>
                            <p className="card-text">Create, Update, Delete supplier</p>
                        </div>
                        </Link>
                    </div>
                    <div className="card text-white bg-secondary col m-3" >
                    <Link className="text-white text-decoration-none" to="/categories">
                        <div className="card-header"><h3>Categories</h3></div>
                        <div className="card-body">
                            <h5 className="card-title">Product Categories</h5>
                            <p className="card-text">Create, Update, Delete product Categories</p>
                        </div>
                        </Link>
                    </div>
                    </div>

                </div>

        )
    }

}
export default Home;