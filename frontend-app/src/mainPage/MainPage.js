import './MainPage.css'
import UserPage from '../userPage/UserPage';

import React, {Component, useState, useEffect} from 'react';
import axios from 'axios';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import Menu from '@mui/material/Menu';
import MenuIcon from '@mui/icons-material/Menu';
import Container from '@mui/material/Container';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import Tooltip from '@mui/material/Tooltip';
import MenuItem from '@mui/material/MenuItem';
import AdbIcon from '@mui/icons-material/Adb';
import TextField from '@mui/material/TextField';
import Switch from '@mui/material/Switch';
import PropTypes from 'prop-types';
import { alpha } from '@mui/material/styles';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TablePagination from '@mui/material/TablePagination';
import TableRow from '@mui/material/TableRow';
import TableSortLabel from '@mui/material/TableSortLabel';
import Paper from '@mui/material/Paper';
import Checkbox from '@mui/material/Checkbox';
import FormControlLabel from '@mui/material/FormControlLabel';
import DeleteIcon from '@mui/icons-material/Delete';
import FilterListIcon from '@mui/icons-material/FilterList';
import { visuallyHidden } from '@mui/utils';
import InputLabel from '@mui/material/InputLabel';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import { Link } from "react-router-dom"; 
import dayjs from 'dayjs';
import Stack from '@mui/material/Stack';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { TimePicker } from '@mui/x-date-pickers/TimePicker';
import { DateTimePicker } from '@mui/x-date-pickers/DateTimePicker';
import { DesktopDatePicker } from '@mui/x-date-pickers/DesktopDatePicker';
import { MobileDatePicker } from '@mui/x-date-pickers/MobileDatePicker';
//____________________________________________________________________________________//

function MainPage() {

    const transdata = [
        {
            origin:"Madrid",
            destiny:"London",
            airline:"asdasd",
            date: "2022-12-25",
            departure:"19:00",
            arrival:"20:00",
            scales:0
        },
        {
            origin:"Madrid",
            destiny:"Barcelona",
            airline:"cxxcxcx",
            date: "2023-01-5",
            departure:"13:00",
            arrival:"22:00",
            scales:6
        },
        {
            origin:"Madrid",
            destiny:"Paris",
            airline:"rtrtrtrtr",
            date: "2022-11-31",
            departure:"11:00",
            arrival:"12:00",
            scales:1
        },
    ]

    const [order, setOrder]         = useState('asc');
    const [orderBy, setOrderBy]     = useState('calories');
    const [selected, setSelected]   = useState([]);
    const [placeList, setPlaceList] = useState([]);
    const [flightsList, setFlightsList] = useState([]);

    useEffect(() => {
      // Simple GET request using axios
      axios.get("http://localhost:8080/flights/api/allplaces")
      .then(response=>{
        console.log(response)
        setPlaceList(response.data);
      })
    },[]);
  
    const handleRequestSort = (event, property) => {
      const isAsc = orderBy === property && order === 'asc';
      setOrder(isAsc ? 'desc' : 'asc');
      setOrderBy(property);
    };
  
    const handleSelectAllClick = (event) => {
      if (event.target.checked) {
        const newSelected = flightsList.map((n) => n.origin);
        setSelected(newSelected);
        return;
      }
      setSelected([]);
    };
  
    const handleClick = (event, name) => {
        window.location='/passengers'
        const selectedIndex = selected.indexOf(name);
        let newSelected = [];
    
        if (selectedIndex === -1)                           newSelected = newSelected.concat(selected, name);
        else if (selectedIndex === 0)                       newSelected = newSelected.concat(selected.slice(1));
        else if (selectedIndex === selected.length - 1)     newSelected = newSelected.concat(selected.slice(0, -1));
        else if (selectedIndex > 0) {
        newSelected = newSelected.concat(
          selected.slice(0, selectedIndex),
          selected.slice(selectedIndex + 1),
        );
      }
      setSelected(newSelected);
    };
  
    const isSelected = (name) => selected.indexOf(name) !== -1;
  
    const label = { inputProps: { 'aria-label': 'Switch demo' } };

    const [origin, setOrigin] = useState('');
    const originChange = (event) => {
        setOrigin(event.target.value);
    };
    const [destiny, setDestiny] = useState('');
    const destinyChange = (event) => {
        setDestiny(event.target.value);
    };

    const openPage=()=>{
      window.location="/passengers"
    }
  
    const handleButton=()=>{
      setFlightsList([]);
      axios.get("http://localhost:8080/flights/api/travel/list/" + origin + "/" + destiny + "/" + date)
      .then(response=>{
        console.log(response.data);
        setFlightsList([...response.data]);
      })
      // console.log("http://localhost:8080/flights/api/travel/" + origin + "/" + destiny);
      //   e.preventDefault();
      //   fetch("http://localhost:8080/flights/api/travel/" + origin + "/" + destiny, {
      //       method:"GET",
      //       headers: {
      //         'Accept': 'application/json, text/plain, */*',
      //         'Content-Type': 'application/json',
      //         },
      //         'credentials': 'same-origin'
      //   })
      //   .then(res => res.json())
      //   .then((data) => {
      //     console.log(data);
      //  })
      //  .catch((err) => {
      //     console.log(err.message);
      //  });
    }

  const [value, setValue] = React.useState(dayjs('2014-08-18T21:11:54'));

  const handleChange = (newValue) => {
    setDate(newValue);
  };

  const [date, setDate] = React.useState(new Date());

  return (
    <>
        <header>
            <AppBar position="static">
            <Container maxWidth="xl">
                <Toolbar disableGutters>
                    <AdbIcon sx={{ display: { xs: 'none', md: 'flex' }, mr: 1 }} />
                        <Typography
                            variant="h6"
                            noWrap
                            component="a"
                            href="/"
                            sx=
                            {{
                                mr: 2,
                                display: { xs: 'none', md: 'flex' },
                                fontFamily: 'monospace',
                                fontWeight: 700,
                                letterSpacing: '.3rem',
                                color: 'inherit',
                                textDecoration: 'none',
                            }}>
                                SOLERA AIRLINES
                        </Typography>
                    </Toolbar>
                </Container>
            </AppBar>
        </header>
        <body>
          <div className = 'bodyHead'>
          <div className='searchFly'>
                <div className='LocationInput'>
                    <Box sx={{ minWidth: 120 }}>
                        <FormControl fullWidth>
                            <InputLabel id="demo-simple-select-label">Origin</InputLabel>
                            <Select
                                labelId="demo-simple-select-label"
                                id="demo-simple-select"
                                value={origin}
                                label="Origin"
                                onChange={originChange}
                            >
                              {
                                placeList.map((content) =>
                                (<MenuItem value={content}>{content}</MenuItem>))
                              }
                            </Select>
                        </FormControl>
                    </Box>
                    <br></br>
                    <Box sx={{ minWidth: 120 }}>
                        <FormControl fullWidth>
                            <InputLabel id="demo-simple-select-label">Destiny</InputLabel>
                            <Select
                                labelId="demo-simple-select-label"
                                id="demo-simple-select"
                                value={destiny}
                                label="Destiny"
                                onChange={destinyChange}
                            >
                              {
                                placeList.map((content) =>
                                (<MenuItem value={content}>{content}</MenuItem>))
                              }
                            </Select>
                        </FormControl>
                    </Box>

                </div>
                <div className='dateSelector'>
                  <LocalizationProvider dateAdapter={AdapterDayjs}>
                    <Stack spacing={3}>
                      <DesktopDatePicker
                        label="Fly date"
                        inputFormat="YYYY-MM-DD"
                        value={date}
                        onChange={handleChange}
                        renderInput={(params) => <TextField {...params} />}
                      />
                    </Stack>
                  </LocalizationProvider>
                </div>
                <div className='searchButton'>
                    <Button variant="contained" onClick = {handleButton}>Search</Button>
                </div>
            </div>
          </div>
          <div className ='flightsTable'>
                <Box sx={{ width: '80%' , margin:'5%'}}>
                    <Paper sx={{ width: '100%', mb: 2 }}>
                        <EnhancedTableToolbar numSelected={selected.length} />
                        <TableContainer sx={{maxHeight:'500px', overflow:'scroll'}}>
                            <Table >
                                <EnhancedTableHead
                                    numSelected={selected.length}
                                    order={order}
                                    orderBy={orderBy}
                                    onRequestSort={handleRequestSort}
                                    rowCount={flightsList.length}
                                />
                                 <TableBody>
                                  {/* if you don't need to support IE11, you can replace the `stableSort` call with:
                                  rows.sort(getComparator(order, orderBy)).slice() */}
                                  {stableSort(flightsList, getComparator(order, orderBy))
                                  .map((flightItem, index) => {
                                    const isItemSelected = isSelected(flightItem.origin);
                                    const labelId = `enhanced-table-checkbox-${index}`;
                                    return (
                                      <tr className='flyRow' onClick={openPage}>
                                        <TableCell align="left" >{flightItem.origin}    </TableCell>
                                        <TableCell align="left">{flightItem.destiny}   </TableCell>
                                        <TableCell align="left">{flightItem.airline}   </TableCell>
                                        <TableCell align="left">{flightItem.date}      </TableCell>
                                        <TableCell align="left">{flightItem.departure} </TableCell>
                                        <TableCell align="left">{flightItem.arrival}   </TableCell>
                                        <TableCell align="left">{flightItem.scales}    </TableCell>
                                      </tr>
                                    );
                                  })}    
                              </TableBody>
                            </Table>
                        </TableContainer>
                    </Paper>
                </Box>
            </div>
        </body>        
    </>
  );
}
export default MainPage;

//-----------------------------------------------------------------------------//
  
  function descendingComparator(a, b, orderBy) {
    if (b[orderBy] < a[orderBy]) {
      return -1;
    }
    if (b[orderBy] > a[orderBy]) {
      return 1;
    }
    return 0;
  }
  
  function getComparator(order, orderBy) {
    return order === 'desc'
      ? (a, b) => descendingComparator(a, b, orderBy)
      : (a, b) => -descendingComparator(a, b, orderBy);
  }
  
  // This method is created for cross-browser compatibility, if you don't
  // need to support IE11, you can use Array.prototype.sort() directly
  function stableSort(array, comparator) {
    const stabilizedThis = array.map((el, index) => [el, index]);
    stabilizedThis.sort((a, b) => {
      const order = comparator(a[0], b[0]);
      if (order !== 0) {
        return order;
      }
      return a[1] - b[1];
    });
    return stabilizedThis.map((el) => el[0]);
  }
  
  const headCells = [
    {
      id: 'origin',
      numeric: false,
      disablePadding: false,
      label: 'origin'
    },
    {
      id: 'destiny',
      numeric: false,
      disablePadding: false,
      label: 'destiny',
    },
    {
      id: 'airline',
      numeric: false,
      disablePadding: false,
      label: 'airline',
    },
    {
      id: 'date',
      numeric: false,
      disablePadding: false,
      label: 'date',
    },
    {
      id: 'departure',
      numeric: false,
      disablePadding: false,
      label: 'departure',
    },
    {
      id: 'arrival',
      numeric: false,
      disablePadding: false,
      label: 'arrival',
    },
    {
      id: 'scales',
      numeric: true,
      disablePadding: false,
      label: 'scales',
    }
  ];
  
  function EnhancedTableHead(props) {
    const { onSelectAllClick, order, orderBy, numSelected, rowCount, onRequestSort } =
      props;
    const createSortHandler = (property) => (event) => {
      onRequestSort(event, property);
    };
  
    return (
      <TableHead>
        <TableRow>
          {headCells.map((headCell) => (
            <TableCell
              key={headCell.id}
              align= 'left'
              padding={headCell.disablePadding ? 'none' : 'normal'}
              sortDirection={orderBy === headCell.id ? order : false}
            >
              <TableSortLabel
                active={orderBy === headCell.id}
                direction={orderBy === headCell.id ? order : 'asc'}
                onClick={createSortHandler(headCell.id)}
              >
                {headCell.label}
                {orderBy === headCell.id ? (
                  <Box component="span" sx={visuallyHidden}>
                    {order === 'desc' ? 'sorted descending' : 'sorted ascending'}
                  </Box>
                ) : null}
              </TableSortLabel>
            </TableCell>
          ))}
        </TableRow>
      </TableHead>
    );
  }
  
  EnhancedTableHead.propTypes = {
    numSelected: PropTypes.number.isRequired,
    onRequestSort: PropTypes.func.isRequired,
    onSelectAllClick: PropTypes.func.isRequired,
    order: PropTypes.oneOf(['asc', 'desc']).isRequired,
    orderBy: PropTypes.string.isRequired,
    rowCount: PropTypes.number.isRequired,
  };
  
  function EnhancedTableToolbar(props) {
    const { numSelected } = props;
  
    return (
      <Toolbar
        sx={{
          pl: { sm: 2 },
          pr: { xs: 1, sm: 1 },
        }}
      >
        <Typography
            sx={{ flex: '1 1 90%' }}
            variant="h6"
            id="tableTitle"
            component="div"
        >
            FLIGHTS
        </Typography>
      </Toolbar>
    );
  }
  