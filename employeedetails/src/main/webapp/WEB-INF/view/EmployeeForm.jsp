<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE>
<html lang="en">
<head>
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--=======================================================================================================================-->
    <!--jquery-->
    <!--=======================================================================================================================-->
    <script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
        crossorigin="anonymous">
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/3.3.7/spacelab/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-L/tgI3wSsbb3f/nW9V6Yqlaw3Gj7mpE56LWrhew/c8MIhAYWZ/FNirA64AVkB5pI" crossorigin="anonymous">
    <!--Model Dialog-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/theme-default.min.css" rel="stylesheet"
        type="text/css">
    <!--=======================================================================================================================-->
    <!--datatables-->
    <!--=======================================================================================================================-->
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" />
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script src="http://malsup.github.com/jquery.form.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    
<script type="text/javascript" class="init">
        $(document).ready(function () {
           
        	var t = $('#example').DataTable({
                "ajax": "http://localhost:8080/employeedetails/employeelist",
                "dataType":"json",
                "columns": 
                 [
                	{
                        "data": "eid"
                    },
                    {
                        "data": "name"
                    },
                    {
                        "data": "email"
                    },
                    {
                        "data": "phno"
                    },
                    {
                        "data": "gender"
                    },
                    {
                        "data": "city"
                    }
                ],
                columnDefs: [{
                    width: "10%",
                    className: "dt-body-center",
                    targets: 6,
                    data: "delete",

                    render: function (data, type, full, meta) {
                        return "<button data-toggle='modal' data-target='#modelUpdate'><i class='fas fa-edit'></i></button>  <button data-toggle='modal' data-target='#Modaldel'><i class='fas fa-trash-alt'></i></button>";
                    }
                }]
            });

            $("#spin").hide();
            
            $("#alertSuccess").hide();
            $("#alertForm").hide();
        
            $.validate({
                modules: 'security',
                onModulesLoaded: function () {
                    var optionalConfig = {
                        fontSize: '12pt',
                        padding: '4px',
                        bad: 'Very bad',
                        weak: 'Weak',
                        good: 'Good',
                        strong: 'Strong'
                    };
                    $('input[name="password"]').displayPasswordStrength(optionalConfig);
                }
            });
            
            $("#btnValidate").click(function() {
            	//$("#form-container").text($("form").serialize());
               	$.ajax({
                   	url: "http://localhost:8080/employeedetails/saveemployee",
                   	type: "POST",
                   	contentType: "text/plain",
                   	data:$('#formInsertion').serialize(),
                   	datatype:'json',
                   	//converters:{"text json":jQuery.parseJSON},
                   	success:function(){
                   		alert("success");
                    },
               		timeout: 13000
                   	
               	});
				
                //event.preventDefault();
                /*
                if (($("#inputEid").val() != '') && ($("#inputName").val() != '') && ($("#inputEmail").val() != '') && ($("#inputPassword").val() != '') && ($("#inputPhone").val() != '')) 
                {
                        $("#spin").show();
                        t = setTimeout(function () {
                            $.ajax({
                                url: 'http://localhost:8080/employeedetails/save',
                                dataType: 'json',
                                success: 
                                function () {
                                    $('#myModal').modal('toggle');
                                    $("#alertSuccess").show();
                                },
                                
                                error: function () {
                                    $("#alertForm").show();
                                }
                            });
                            $("#spin").hide();
                        }, 2000);
                    }
                */
                
    		});//btnvalidate
        });//doc.ready
 
        
        


            
           
    </script>
</head>

<body>
    <header>
        <!--=======================================================================================================================-->
        <!--navbar-->
        <!--========================================================================================================================-->
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <!--================================================================================================================-->
                <!--nav header-->
                <!--================================================================================================================-->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Brand</a>
                </div>
                <!--=======================================================================================================================-->
                <!--navbar collapse-->
                <!--=======================================================================================================================-->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
                        <li><a href="#">Link</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                                <li class="divider"></li>
                                <li><a href="#">One more separated link</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!--=======================================================================================================================-->
                    <!--search-->
                    <!--=======================================================================================================================-->
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                    <!--=======================================================================================================================-->
                    <!--link-->
                    <!--=======================================================================================================================-->
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Link</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <article>
        <div class="container">
            <div class="jumbotron" id="jumbotron" style="background: url('https://amazingpict.com/wp-content/uploads/2015/02/human-resources.jpg') no-repeat; height: 550px ; width: 1200px; position: relative">
                <br><br><br><br><br><br><br><br><br><br><br><br><br>
                <h2>Employee Details</h2>
                <!--line-->
                <hr class="my-4">
                <p>Enter the details of your employee in here!!!</p>
                <p class="lead">
                    <a class="btn btn-primary btn-lg" role="button" id="#getstarted">
                        Get Started </a>
                </p>
            </div>
        </div>
    </article>
    <!--=======================================================================================================================-->
    <!--alert Success-->
    <!--=======================================================================================================================-->
    <div class="alert alert-success container" id="alertSuccess">
        <strong>Success!</strong> Data is inserted successfully !!! <a href="#" class="alert-link">Edit</a> the
        inserted data.
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    
    <article>
        <!--==================================================================-->
        <!--container-->
        <!--==================================================================-->
        <div class="container">
            <p class="lead">
                <!--==================================================================-->
                <!--table-->
                <!--==================================================================-->
                <table id="example" class="display table-bordered table-striped" style="width:100%">
                    <thead>
                        <tr>
                            <th>Employee id</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Phone Number</th>
                            <th>Gender</th>
                            <th>City</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                </table>
                <!--==================================================================-->
                <!--ADD ROW-->
                <!--==================================================================-->
                <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" role="button" id="addemployee">
                    ADD ROW</button>
                <!--==================================================================-->
                <!-- The Modal -->
                <!--==================================================================-->
                <div class="modal" id="myModal">
                    <div class="modal-dialog" role="document">
                        <!--==================================================================-->
                        <!--Modal-content-->
                        <!--==================================================================-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                                <h3 class="modal-title">Employee</h3>
                            </div>
                            <!--==================================================================-->
                            <!--Modal-Body-->
                            <!--==================================================================-->
                            <div class="modal-body container-fluid">
                                <div class="container-fluid" id="form-container">
                                    
                                    <form class="form-horizontal" id="formInsertion"
                                        method="post" action="#">
                                        <!--==================================================================-->
                                        <!--alertForm-->
                                        <!--==================================================================-->
                                        <div class="alert alert-danger container-danger" id="alertForm">
                                            <strong>Error!</strong> Unexpected Error occurred. Please try again !!!
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <fieldset>
                                            <!--==================================================================-->
                                            <!--ID-->
                                            <!--==================================================================-->
                                            <div class="form-group">
                                            	<label for="inputId" class="col-lg-2 control-label">EmployeeId</label>
                                                	<div class="col-lg-10">
                                                    	<input type="text" class="form-control" id="inputEid" name="id" placeholder="employee id" data-validation="custom" data-validation-regexp="^[A-Za-z0-9 '.]+$" data-validation-length="3-30" data-validation-error-msg="User name has to be an alphanumeric value (7 chars)" >
                                                	</div>
                                             </div>
                                            
                                            <!--==================================================================-->
                                            <!--Name-->
                                            <!--==================================================================-->
                                            <div class="form-group">
                                            	<label for="inputname" class="col-lg-2 control-label">name</label>
                                                	<div class="col-lg-10">
                                                    	<input type="text" class="form-control" id="inputname" name="name" placeholder="name" data-validation="custom" data-validation-regexp="^[A-Za-z '.]+$" data-validation-length="3-30" data-validation-error-msg="User name has to be an alpha value (3-30 chars)" >
                                                	</div>
                                             </div>

                                            <!--==================================================================-->
                                            <!--Email-->
                                            <!--==================================================================-->
                                            <div class="form-group">
                                            	<label for="inputEmail" class="col-lg-2 control-label">Email</label>
                                                	<div class="col-lg-10">
                                                    	<input type="email" class="form-control" id="inputEmail" placeholder="abc@gmail.com" data-validation="email" name="Email">
                                                    </div>
                                            </div>

                                            <!--==================================================================-->
                                            <!--Password-->
                                            <!--==================================================================-->
                                            <div class="form-group">
                                                <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                                                <div class="col-lg-10">
                                                    <input type="password" class="form-control" id="inputPassword" name="password" autocomplete="off"
                                                        data-validation="strength" minlength="8" maxlength="15" autocomplete="off" data-validation-strength="2" />
                                                </div>
                                            </div>
                                            <!--==================================================================-->
                                            <!--Phone-->
                                            <!--==================================================================-->
                                            <div class="form-group">
                                                <label for="inputPhone" class="col-lg-2 control-label">Phone</label>
                                                <div class="col-lg-10">
                                                    <input type="tel" class="form-control" id="inputPhone" value="" />
                                                </div>
                                            </div>
                                            <!--==================================================================-->
                                            <!--Gender-->
                                            <!--==================================================================-->
                                            <div class="form-group">
                                                <label class="col-lg-2 control-label">Gender</label>
                                                <div class="col-lg-10">
                                                    <div class="radio">
                                                    <label>
                                                    	<input type="radio" name="Gender" id="optionsRadios1" value="Male" checked  />
                                                            Male
                                                    </label>
                                                            
                                                    </div>
                                                    <div class="radio">
                                                    <label>
                                                    	<input type="radio" name="Gender" id="optionsRadios2" value="Female" />
                                                            Female
                                                    </label>
                                                    </div>
                                                </div>
                                            </div>
                                            <!--==================================================================-->
                                            <!--city-->
                                            <!--==================================================================-->
                                            <div class="form-group">
                                                <label for="select" class="col-lg-2 control-label">City</label>
                                                <div class="col-lg-10">
                                                    <select class="form-control" id="select" name="City" >
                                                        <option value="Chennai">Chennai</option>
                                                        <option value="Madurai">Madurai</option>
                                                        <option value="Trichy">Trichy</option>
                                                        <option value="Theni">Theni</option>
                                                        <option value="Salem">Salem</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <!--==================================================================-->
                                            <!--buttons-->
                                            <!--==================================================================-->
                                            <div class="form-group">
                                                <div class="col-lg-10 col-lg-offset-2" style="float:right">
                                                    <button type="reset" class="btn btn-default">Cancel</button>
                                                    <button type="submit" class="btn btn-primary ld ld-ext-right running"
                                                        id="btnValidate"value="Update" >Save<i hidden class="fa fa-circle-o-notch fa-spin" style="font-size:18pxss"
															id="spin">
														</i></button>
                                                        
                                                </div>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                            <!--==================================================================-->
                            <!--end of Modal-Body-->
                            <!--==================================================================-->
                        </div>
                    </div>
                    <!--==================================================================-->
                    <!-- end of The Modal -->
                    <!--==================================================================-->
                </div>
                <!--==================================================================-->
                <!--model Update-->
                <!--==================================================================-->
				<div class="modal" id="modalUpdate">
                    <div class="modal-dialog" role="document">
                        <!--==================================================================-->
                        <!--Modal-content-->
                        <!--==================================================================-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                                <h3 class="modal-title">Employee</h3>
                            </div>
                            <!--==================================================================-->
                            <!--Modal-Body-->
                            <!--==================================================================-->
                            <div class="modal-body container-fluid">
                                <div class="container-fluid" id="form-container">
                                    <form class="form-horizontal" id="formUpdation"
                                        method="post">
                                        <!--==================================================================-->
                                        <!--alertForm-->
                                        <!--==================================================================-->
                                        <div class="alert alert-danger container-danger" id="alertForm">
                                            <strong>Error!</strong> Unexpected Error occurred. Please try again !!!
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <fieldset>
                                            <!--==================================================================-->
                                            <!--ID-->
                                            <!--==================================================================-->
                                            <div class="form-group">
                                                <label for="updateId" class="col-lg-2 control-label">EmployeeId</label>
                                                <div class="col-lg-10">
                                                    <input type="text" class="form-control" id="updateEid"
                                                        data-validation="custom" 
                                                        data-validation-length="3-30" data-validation-error-msg="User name has to be an alpha value (3-30 chars)"
                                                        />
                                                </div>
                                            </div>
                                            <!--==================================================================-->
                                            <!--Name-->
                                            <!--==================================================================-->
                                            <div class="form-group">
                                                <label for="updateName" class="col-lg-2 control-label" >Name</label>
                                                <div class="col-lg-10">
                                                    <input type="text" class="form-control" id="updateName"
                                                        data-validation="custom" data-validation-regexp="^[A-Za-z '.]+$"
                                                        data-validation-length="3-30" data-validation-error-msg="User name has to be an alpha value (3-30 chars)"
                                                        />
                                                </div>
                                            </div>
                                            <!--==================================================================-->
                                            <!--Email-->
                                            <!--==================================================================-->
                                            <div class="form-group">
                                                <label for="updateEmail" class="col-lg-2 control-label" >Email</label>
                                                <div class="col-lg-10">
                                                    <input type="email" class="form-control" id="updateEmail"
                                                        data-validation="email" />
                                                </div>
                                            </div>
                                            <!--==================================================================-->
                                            <!--Password-->
                                            <!--==================================================================-->
                                            <div class="form-group">
                                                <label for="updatePassword" class="col-lg-2 control-label">Password</label>
                                                <div class="col-lg-10">
                                                    <input type="password" class="form-control" id="updatePassword" name="password" autocomplete="off"
                                                        data-validation="strength" minlength="8" maxlength="15" data-validation-strength="2"/>  
                                                </div>
                                            </div>
                                            <!--==================================================================-->
                                            <!--Phone-->
                                            <!--==================================================================-->
                                            <div class="form-group">
                                                <label for="updatePhone" class="col-lg-2 control-label" >Phone</label>
                                                <div class="col-lg-10">
                                                    <input type="tel" class="form-control" id="updatePhone" />
                                                </div>
                                            </div>
                                            <!--==================================================================-->
                                            <!--Gender-->
                                            <!--==================================================================-->
                                            <div class="form-group">
                                                <label class="col-lg-2 control-label">Gender</label>
                                                <div class="col-lg-10">
                                                    <div class="radio">
                                                            <radiobutton name="Gender" id="updateRadios1" value="Male" checked="" />
                                                            Male
                                                    </div>
                                                    <div class="radio">
                                                            <radiobutton name="Gender" id="updateRadios2" value="Female" />
                                                            Female
                                                    </div>
                                                </div>
                                            </div>
                                            <!--==================================================================-->
                                            <!--city-->
                                            <!--==================================================================-->
                                            <div class="form-group">
                                                <label for="select" class="col-lg-2 control-label">City</label>
                                                <div class="col-lg-10">
                                                    <select class="form-control" id="update" name="City">
                                                        <option value="Chennai">Chennai</option>
                                                        <option value="Madurai">Madurai</option>
                                                        <option value="Trichy">Trichy</option>
                                                        <option value="Theni">Theni</option>
                                                        <option value="Salem">Salem</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <!--==================================================================-->
                                            <!--buttons-->
                                            <!--==================================================================-->
                                            <div class="form-group">
                                                <div class="col-lg-10 col-lg-offset-2" style="float:right">
                                                    <button type="reset" class="btn btn-default">Cancel</button>
                                                    <button type="submit" class="btn btn-primary ld ld-ext-right running"
                                                        id="btnUpdate">Save<i hidden class="fa fa-circle-o-notch fa-spin" style="font-size:18pxss"
															id="spin">
														</i></button>
                                                        
                                                </div>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                            <!--==================================================================-->
                            <!--end of Modal-Body-->
                            <!--==================================================================-->
                        </div>
                    </div>
                    <!--==================================================================-->
                    <!-- end of The Modal -->
                    <!--==================================================================-->
                </div>
                <!--==================================================================-->
                <!--model delete -->
                <!--==================================================================-->
                <div class="modal" id="Modaldel">
                    <div class="modal-dialog" role="document">
                        <!--==================================================================-->
                        <!--The Modal content-->
                        <!--==================================================================-->
                        <div class="modal-content">
                            <!--==================================================================-->
                            <!-- The Modal header-->
                            <!--==================================================================-->
                            <div class="modal-header">
                                <h5 class="modal-title">DELETE</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <!--==================================================================-->
                            <!--The Modal body-->
                            <!--==================================================================-->
                            <div class="modal-body">
                                <p>Are you sure do you want to delete?</p>
                            </div>
                            <!--==================================================================-->
                            <!--The Modal footer-->
                            <!--==================================================================-->
                            <div class="modal-footer">
                            	
                                <button type="button" class="btn btn-primary">Delete</button>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                        <!--==================================================================-->
                        <!--end of The Modal content-->
                        <!--==================================================================-->
                    </div>
                </div>
                <!--==================================================================-->
                <!-- end of The Modal -->
                <!--==================================================================-->
            </p>
        </div>
        <!--==================================================================-->
        <!--end container-->
        <!--==================================================================-->
    </article>
    <footer>
        <div id="results"></div>
    </footer>
</body>

</html>