# Community-Care

A complaint tracker for gated communities. Residents can sign up, log in, and raise complaints about things going wrong in their community, and keep an eye on the ones they've already submitted.

I'm building this to get hands-on with Java full stack development. Reading about how the controller, service, and database layers fit together only gets you so far, so I picked a project that needed all of them.

It's still a work in progress, so some parts are rough or missing. I've listed what's done and what's next below.

## What it can do right now

**For residents**
- Register and log in
- Get a personal dashboard after logging in
- Submit a complaint
- See all the complaints you've submitted
- Edit a complaint after submitting it
- Cancel a complaint
- Track your complaints

**For the admin / president**
- Log in (the dashboard is still under construction)

## Built with

- Java 21
- Spring MVC for the web layer
- Hibernate for talking to the database
- MySQL
- JSP, HTML and CSS for the pages
- Maven for dependencies and builds
- Apache Tomcat 11 to run it

## How the code is organised

I've kept it split into layers so each part has one job:

- **Controller**: takes in the HTTP requests
- **Service**: where the actual logic lives
- **DAO**: does the database work
- **Model**: the entities (the data the app deals with)
- **Config**: Spring and Hibernate setup
- **Views**: the JSP pages

## Running it on your machine

You'll need Java 21, Maven, MySQL, Tomcat 11, and an IDE. I use Eclipse.

**1. Set up the database**

Create an empty MySQL database called `community_db`, and make sure MySQL is running. Hibernate is set up to manage the schema, so you shouldn't need to create tables by hand.

**2. Add your own credentials**

Open `Configs.java` and put in your own database URL, username, and password. Please don't commit your real password to GitHub. I'd suggest keeping it local only.

**3. Get the code**

```bash
git clone https://github.com/mekadeeraj-k/Community-care.git
```

**4. Run it**

1. Import the project into Eclipse as an existing Maven project.
2. Update the Maven project so the dependencies download.
3. Set up Tomcat 11 in your IDE.
4. Run the project on the Tomcat server.
5. Open `http://localhost:8080/Community-Care/` in your browser.

## What's next

- Make the UI look better
- Add complaint history to the resident dashboard
- Finish the president dashboard (it's still under construction 🚧). The plan is for the president to see all the residents' complaints in one place and update the status of each one

## About me

I'm Deeraj Kumar Meka, learning Java full stack development and building things as I go. If you have feedback or suggestions, I'd love to hear them.

GitHub: [mekadeeraj-k](https://github.com/mekadeeraj-k)