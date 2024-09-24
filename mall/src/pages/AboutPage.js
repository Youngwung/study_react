import React from 'react'
import { Link } from 'react-router-dom'
import BasicLayout from '../layouts/BasicLayout'

export default function AboutPage(props) {
	return (
		<BasicLayout>
			<div className='text-3xl'>
				<div>
					<Link to={'/'}>Main</Link>
				</div>
				<div>About Page</div>
			</div>
		</BasicLayout>
	)
}
