<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
        %{--BLACK STAR--}%
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    %{--<asset:stylesheet src="application.css"/>--}%

    <g:layoutHead/>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>

    <asset:javascript src="assets/vendor_components/popper/dist/popper.min.js"/>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>

    <!--alerts CSS -->
    <asset:stylesheet src="assets/vendor_components/sweetalert/sweetalert.css"/>

</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Black Star</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Registros
                </a>
                <div class="dropdown-menu " aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="./registroclientes">Registros de Clientes</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="./prestamo">Registrar un préstamo</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>


<div class="container mt-3">
    <g:layoutBody/>
</div>



%{--<div class="footer row" role="contentinfo">--}%
    %{--<div class="col">--}%
        %{--<a href="http://guides.grails.org" target="_blank">--}%
            %{--<asset:image src="advancedgrails.svg" alt="Grails Guides" class="float-left"/>--}%
        %{--</a>--}%
        %{--<strong class="centered"><a href="http://guides.grails.org" target="_blank">Grails Guides</a></strong>--}%
        %{--<p>Building your first Grails app? Looking to add security, or create a Single-Page-App? Check out the <a href="http://guides.grails.org" target="_blank">Grails Guides</a> for step-by-step tutorials.</p>--}%

    %{--</div>--}%
    %{--<div class="col">--}%
        %{--<a href="http://docs.grails.org" target="_blank">--}%
            %{--<asset:image src="documentation.svg" alt="Grails Documentation" class="float-left"/>--}%
        %{--</a>--}%
        %{--<strong class="centered"><a href="http://docs.grails.org" target="_blank">Documentation</a></strong>--}%
        %{--<p>Ready to dig in? You can find in-depth documentation for all the features of Grails in the <a href="http://docs.grails.org" target="_blank">User Guide</a>.</p>--}%

    %{--</div>--}%

    %{--<div class="col">--}%
        %{--<a href="https://grails-slack.cfapps.io" target="_blank">--}%
            %{--<asset:image src="slack.svg" alt="Grails Slack" class="float-left"/>--}%
        %{--</a>--}%
        %{--<strong class="centered"><a href="https://grails-slack.cfapps.io" target="_blank">Join the Community</a></strong>--}%
        %{--<p>Get feedback and share your experience with other Grails developers in the community <a href="https://grails-slack.cfapps.io" target="_blank">Slack channel</a>.</p>--}%
    %{--</div>--}%
%{--</div>--}%


<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="utilidades.js"/>

<!-- popper -->


<!-- Sweet-Alert  -->
<asset:javascript src="assets/vendor_components/sweetalert/sweetalert.min.js"/>
<asset:javascript src="assets/vendor_components/sweetalert/jquery.sweet-alert.custom.js"/>

%{--<asset:javascript src="application.js"/>--}%

</body>
</html>
